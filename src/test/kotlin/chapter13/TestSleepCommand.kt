package chapter13

import org.junit.Assert.assertTrue
import org.junit.Test

class TestSleepCommand {

    private var commandExecuted = false

    @Test
    fun testSleep() {
        val wakeUp = object : Command {
            override fun execute() {
                commandExecuted = true
            }
        }

        val e = ActiveObjectEngine()
        val c = SleepCommand(1001, e, wakeUp)
        e.addCommand(c)
        val start = System.currentTimeMillis()
        e.run()
        val stop = System.currentTimeMillis()
        val sleepTime = stop - start

        assertTrue("SleepTime $sleepTime expected > 1000", sleepTime > 1000)
        assertTrue("SleepTime $sleepTime expected < 1100", sleepTime < 1100)
        assertTrue("Command Executed", commandExecuted)
    }

}
