This repository contains examples of different programming challenges.

####Berlin Clock
See http://agilekatas.co.uk/katas/BerlinClock-Kata for more details.
The implementation is *fjab.berlinclock.BerlinClock.java* and the tests are on *fjab.berlinclock.BerlinClockTest.java*.
Only a few tests of those specified on the website have been implemented.


####String Calculator
The details to implement the kata has been taken from http://www.peterprovost.org/blog/2012/05/02/kata-the-only-way-to-learn-tdd/.
The implementation is *fjab.stringcalculator.StringCalculator* and the tests are on *fjab.stringcalculator.StringCalculatorTest*.


####Optimal Change
See https://en.wikipedia.org/wiki/Change-making_problem for more details.

The solution has been implemented using 3 different algorithms: greedy iterative, greedy recursive and dynamic programming.
The interface *fjab.optimalchange.OptimalChange* has been defined and each of the solutions has been implemented by extending said interface.
To ensure that the order in which the coins are given is not dependent upon the implementation used to solve the problem, the specification of the method *OptimalChange.optimalChangeFor* states that the coins must be returned sorted desc by denomination.

The 3 implementations are: *fjab.optimalchange.DPImpl*, *fjab.optimalchange.GreedyIterativeImpl* and *fjab.optimalchange.GreedyRecursiveImpl*.
And the corresponding tests: *fjab.optimalchange.DPImplTest*, *fjab.optimalchange.GreedyIterativeImplTest* and *fjab.optimalchange.GreedyRecursiveImplTest*.
