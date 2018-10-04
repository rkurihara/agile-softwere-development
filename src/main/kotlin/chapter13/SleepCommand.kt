package chapter13

class SleepCommand(
    milliseconds: Long,
    e: ActiveObjectEngine,
    wakeupCommand: Command
) : Command {

    private var wakeupCommand: Command
    private var engine: ActiveObjectEngine
    private var sleepTime: Long = 0
    private var startTime: Long = 0
    private var started = false

    init {
        sleepTime = milliseconds
        engine = e
        this.wakeupCommand = wakeupCommand
    }

    override fun execute() {
        val currentTime = System.currentTimeMillis()
        if (!started) {
            started = true
            startTime = currentTime
            engine.addCommand(this)
        } else if ((currentTime - startTime) < sleepTime) {
            engine.addCommand(this)
        } else {
            engine.addCommand(wakeupCommand)
        }
    }
}
