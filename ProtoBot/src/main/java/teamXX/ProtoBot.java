/**	
Copyright (c) 2020 Markus Borg

Building on work by Mathew A. Nelson and Robocode contributors.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package teamXX;

import etsa03.*;
import robocode.TeamRobot;
import robocode.MessageEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;

/**
 * @author Markus Borg
 * 
 * Barebone robot prepared for the ETSA03 project.
 */
public class ProtoBot extends TeamRobot {
	
	/**
	 * The main loop controlling the robot behavior.
	 */
	@Override
	public void run() {
		ModuleA subSysA = new ModuleA();
		ModuleB subSysB = new ModuleB();
		ModuleC subSysC = new ModuleC();
		
		while (true) {
			setTurnRadarRight(Double.POSITIVE_INFINITY);
			execute();
		}
	}
	
	/**
	 * Describes the action taken when a robot has been scanned.
	 * 
	 * @param e The ScannedRobotEvent provided by Robocode.
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
	}
	
	/**
	 * Describes the action taken when a robot has been destroyed.
	 * 
	 * @param event The RobotDeathEvent provided by Robocode.
	 */
	@Override
	public void onRobotDeath(RobotDeathEvent e) {
	}
	
	/**
	 * onMessageReceived: Describes how incomming messages are treated.
	 */
	@Override
	public void onMessageReceived(MessageEvent e) {
		// Set our colors
		if (e.getMessage() instanceof RobotColors) {
			RobotColors c = (RobotColors) e.getMessage();
			setBodyColor(c.bodyColor);
			setGunColor(c.gunColor);
			setRadarColor(c.radarColor);
			setScanColor(c.scanColor);
			setBulletColor(c.bulletColor);
		}
	}
}