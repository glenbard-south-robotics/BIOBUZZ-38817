package org.firstinspires.ftc.teamcode.opmode.auto

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.subsystems.Drive

@Autonomous(name = "ExampleAuto")
class ExampleAuto : LinearOpMode() {
    override fun runOpMode() {
        val drive = Drive(this.hardwareMap, Gamepad())

        waitForStart()

        // Using sleep() works, but if a driver hits the "STOP" button on the driver station.
        // while the robot is sleeping, the robot might keep driving for the rest of that second!
        // Look up opModeIsActive() to see how to make your robot safely check if it should stop immediately.

        drive.setMotorPowers(1.0, 1.0) // Go forward
        sleep(1000) // Wait 1 second
        drive.setMotorPowers(0.0, 0.0) // Stop

        // Driving using time (sleep) changes depending on how full your battery is.
        // Once you learn about motor encoders, see if you can rewrite this auto to drive by a specific
        // distance (like inches or centimeters) instead of time!
    }
}
