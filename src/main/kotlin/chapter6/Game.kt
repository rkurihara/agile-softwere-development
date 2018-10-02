package chapter6

class Game {


    fun score() = scoreForFrame(itsCurrentFrame)

    fun add(pins: Int) {
        itsScorer.addThrow(pins)
        adjustCurrentFrame(pins)
    }

    private fun adjustCurrentFrame(pins: Int) {
        if (lastBallInFrame(pins)) {
            advanceFrame()
        } else {
            firstThrowInFrame = false
        }
    }

    private fun lastBallInFrame(pins: Int) = strike(pins) || !firstThrowInFrame

    private fun strike(pins: Int) = firstThrowInFrame && pins == 10

    private fun advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1)
    }

    fun scoreForFrame(theFrame: Int): Int = itsScorer.scoreForFrame(theFrame)

    private var itsCurrentFrame = 1
    private var firstThrowInFrame = true
    private var itsScorer: Scorer = Scorer()
}
