package chapter14

abstract class Application {

    private var isDone = false
    protected abstract fun init()
    protected abstract fun idle()
    protected abstract fun cleanup()

    protected fun setDone() {
        isDone = true
    }

    protected fun done() = isDone

    fun run() {
        init()
        while (!done()) {
            idle()
            cleanup()
        }
    }

}
