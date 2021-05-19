# HotelAutomation

# Problem Statement
(Average time to write a solution 4-8 hrs)
A very prestigious chain of hotels is facing a problem of huge consumption of electricity bills for
its electronic equipment. The common equipment, like lights, ACs, etc are currently controlled
manually, by the hotel staff, using manual switches. Hotel Management wants to optimise the
usage of electricity consumption and also ensure that there is no inconvenience caused to the
guests and staff. So, it has installed Motion Sensors at appropriate places and has approached
you to program a Controller which takes inputs from these sensors and controls various
equipment.
The way the hotel equipment are organised and the requirements for the Controller are listed
below:
● A Hotel can have multiple floors
● Each floor can have multiple main corridors and sub corridors
● Both main corridor and sub corridor have one light each
● Both main and sub corridor lights consume 5 units of power when ON
● Both main and sub corridor have independently controllable ACs
● Both main and sub corridor ACs consume 10 units of power when ON
● All the lights in all the main corridors need to be switched ON between 6 PM to 6 AM,
which is the Night Time slot
● By default, all ACs are switched ON, all the time
● When a motion is detected in one of the sub corridors the corresponding lights need to
be switched ON between 6 PM to 6 AM (Night Time slot)
● The total power consumption of all the ACs and lights combined should not exceed
(Number of Main corridors * 15) + (Number of sub corridors * 10) units of per floor. Sub
corridor AC could be switched OFF to ensure that the power consumption is not more
than the specified maximum value
● When there is no motion for more than a minute the sub corridor lights should be
switched OFF and AC needs to be switched ON
Motion in sub-corridors is input to the controller, which needs to keep track and optimise the
power consumption.
Write a program that takes input values for Floors, Main corridors, Sub corridors and takes
different external inputs for motion in sub corridors. For each input, the program prints out the
state of all the lights and ACs in the hotel. For simplicity, assume that the controller is operating
at the Night-Time.


# Sample input and output below -
● Number of floors: 2
● Main corridors per floor: 1
● Sub corridors per floor: 2
Subsequent Inputs from
Sensors
The output from the controller for corresponding sensor input
The default state (when the
program is first to run)

Floor 1
Main corridor 1 Light 1: ON AC: ON
Sub corridor 1 Light 1: OFF AC: ON
Sub corridor 2 Light 2: OFF AC: ON
Floor 2
Main corridor 1 Light 1: ON AC: ON
Sub corridor 1 Light 1: OFF AC: ON
Sub corridor 2 Light 2: OFF AC: ON

Movement in Floor 1, Sub
corridor 2

Floor 1
Main corridor 1 Light 1: ON AC: ON
Sub corridor 1 Light 1: OFF AC: OFF
Sub corridor 2 Light 2: ON AC: ON
Floor 2
Main corridor 1 Light 1: ON AC: ON
Sub corridor 1 Light 1: OFF AC: ON
Sub corridor 2 Light 2: OFF AC: ON

No movement in Floor 1,
Sub corridor 2 for a
minute

Floor 1
Main corridor 1 Light 1: ON AC: ON
Sub corridor 1 Light 1: OFF AC: ON
Sub corridor 2 Light 2: OFF AC: ON
Floor 2
Main corridor 1 Light 1: ON AC: ON
Sub corridor 1 Light 1: OFF AC: ON
Sub corridor 2 Light 2: OFF AC: ON

Since the hotel management is trying this for the first time, it would be changing the
requirements as to which electronic equipment is controlled and the criteria based on which they
are controlled. Therefore, the solution design should be flexible enough to absorb these
changes without a need to make significant changes in the program.
