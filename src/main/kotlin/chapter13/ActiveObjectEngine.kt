package chapter13

import java.util.LinkedList

class ActiveObjectEngine {

    val itsCommands = LinkedList<Command>()

    fun addCommand(c: Command) {
        itsCommands.add(c)
    }

    fun run() {
        while (itsCommands.isNotEmpty()) {
            val c = itsCommands.first
            itsCommands.removeFirst()
            c.execute()
        }
    }

}

