package chapter6

class Scorer {

    fun addThrow(pins: Int) {
        itsThrows[itsCurrentThrow++] = pins
    }

    fun scoreForFrame(theFrame: Int): Int {
        ball = 0
        var score = 0
        for (currentFrame in 0 until theFrame) {
            when {
                strike() -> {
                    score += 10 + nextTwoBallsForStrike()
                    ball++
                }
                spare() -> {
                    score += 10 + nextBallForSpare()
                    ball += 2
                }
                else -> {
                    score += twoBallsInFrame()
                    ball += 2
                }
            }
        }
        return score
    }

    private fun strike() = itsThrows[ball] == 10

    private fun spare() = (itsThrows[ball] + itsThrows[ball + 1] == 10)

    private fun nextTwoBallsForStrike() = itsThrows[ball + 1] + itsThrows[ball + 2]

    private fun nextBallForSpare() = itsThrows[ball + 2]

    private fun twoBallsInFrame() = itsThrows[ball] + itsThrows[ball + 1]

    private var ball = 0
    private val itsThrows = IntArray(21)
    private var itsCurrentThrow = 0


}
