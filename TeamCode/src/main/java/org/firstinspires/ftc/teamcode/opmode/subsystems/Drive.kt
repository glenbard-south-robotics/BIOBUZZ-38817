package org.firstinspires.ftc.teamcode.opmode.subsystems

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.HardwareMap

// This is an example Arcade Drive subsystem, see what changes you can make to make this better.
class Drive(hardwareMap: HardwareMap, val gamepad: Gamepad) {
    private val leftDrive = hardwareMap.get(DcMotor::class.java, "leftDrive")

    // The right motor needs to be reversed
    private val rightDrive = hardwareMap.get(DcMotor::class.java, "rightDrive").apply {
        direction = DcMotorSimple.Direction.REVERSE
    }

    // Takes motor powers and tells the motors how fast to go
    fun setMotorPowers(leftPower: Double, rightPower: Double) {
        // What happens if leftPower or rightPower are greater than 1.0?
        // Look up the .coerceIn() method to see how to keep numbers in a range from (-1.0, 1.0)
        leftDrive.power = leftPower
        rightDrive.power = rightPower
    }

    fun teleopRun() {
        // Joysticks wear out and might not return 0.0 when released.
        // How can you write a small if statement to ignore tiny joystick movements (like less than 0.05)?
        // This is called a "Deadzone"

        val x = gamepad.left_stick_x.toDouble()
        val y =
            -gamepad.left_stick_y.toDouble() // The stick's y values are reversed, so negate (-) it to make it regular.

        // Can you create a "Slow Mode" button?
        // Hint: Check if a gamepad button (like gamepad.x) is pressed.
        // If it is, multiply the final powers by a smaller value like 0.5 before sending them to the setMotorPowers() function.

        val leftPower = y + x
        val rightPower = y - x

        setMotorPowers(leftPower, rightPower)
    }
}