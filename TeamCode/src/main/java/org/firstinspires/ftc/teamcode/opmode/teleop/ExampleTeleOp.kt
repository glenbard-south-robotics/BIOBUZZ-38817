package org.firstinspires.ftc.teamcode.opmode.teleop

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.opmode.subsystems.Drive

@TeleOp(name = "ExampleTeleOp")
class ExampleTeleOp : LinearOpMode() {
    override fun runOpMode() {
        // Initialize the Drive subsystem and pass it gamepad1 for driver controls
        val drive = Drive(this.hardwareMap, this.gamepad1)

        // Telemetry shows up on the Driver Station phone screen
        telemetry.addData("Status", "Initialized")
        telemetry.update()

        waitForStart()

        // This loop runs continuously until the driver presses the square "STOP" button
        while (opModeIsActive()) {
            // Tell the drive subsystem to read the gamepad inputs and update the motors
            drive.teleopRun()

            // CHALLENGE 1: It is incredibly useful to see what the robot is thinking!
            // Can you use 'telemetry.addData()' to print out the current left and right motor powers?
            // Don't forget to call 'telemetry.update()' at the end of the loop!

            // CHALLENGE 2: In robotics, code speed is everything.
            // Why is it important that this while loop repeats as fast as possible without any sleep() commands?
        }
    }
}
