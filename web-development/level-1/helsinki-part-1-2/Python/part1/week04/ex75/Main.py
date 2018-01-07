#ex75 week4 part1
#Decreasing DecreasingCounter

#imports
from DecreasingCounter import *

#main logic
counter = DecreasingCounter(100)
counter.printValue()

counter.decrease()
counter.printValue()

counter.decrease()
counter.printValue()

counter.reset()
counter.decrease()
counter.printValue()
