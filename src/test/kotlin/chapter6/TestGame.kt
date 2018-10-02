package chapter6

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TestGame {

    @Test
    fun testTwoThrowsNoMark() {
        val g = Game()
        g.add(5)
        g.add(4)
        assertThat(9, `is`(g.score()))
    }

    @Test
    fun testFourThrowsNoMark() {
        val g = Game()
        g.add(5)
        g.add(4)
        g.add(7)
        g.add(2)
        assertThat(18, `is`(g.score()))
        assertThat(9, `is`(g.scoreForFrame(1)))
        assertThat(18, `is`(g.scoreForFrame(2)))
    }

    @Test
    fun testSimpleSpare() {
        val g = Game()
        g.add(3)
        g.add(7)
        g.add(3)
        assertThat(13, `is`(g.scoreForFrame(1)))
    }

    @Test
    fun testSimpleFrameAfterSpare() {
        val g = Game()
        g.add(3)
        g.add(7)
        g.add(3)
        g.add(2)
        assertThat(13, `is`(g.scoreForFrame(1)))
        assertThat(18, `is`(g.scoreForFrame(2)))
        assertThat(18, `is`(g.score()))
    }

    @Test
    fun testSimpleStrike() {
        val g = Game()
        g.add(10)
        g.add(3)
        g.add(6)
        assertThat(19, `is`(g.scoreForFrame(1)))
        assertThat(28, `is`(g.score()))
    }

    @Test
    fun testPerfectGame() {
        val g = Game()
        for (i in 0 until 12) {
            g.add(10)
        }
        assertThat(300, `is`(g.score()))
    }

    @Test
    fun testEndOfArray() {
        val g = Game()
        for (i in 0..8) {
            g.add(0)
            g.add(0)
        }
        g.add(2)
        g.add(8)
        g.add(10)
        assertThat(20, `is`(g.score()))
    }

    @Test
    fun testSampleGame() {
        val g = Game()
        g.add(1)
        g.add(4)
        g.add(4)
        g.add(5)
        g.add(6)
        g.add(4)
        g.add(5)
        g.add(5)
        g.add(10)
        g.add(0)
        g.add(1)
        g.add(7)
        g.add(3)
        g.add(6)
        g.add(4)
        g.add(10)
        g.add(2)
        g.add(8)
        g.add(6)
        assertThat(133, `is`(g.score()))
    }

    @Test
    fun testHeartBreak() {
        val g = Game()
        for (i in 0..10) {
            g.add(10)
        }
        g.add(9)
        assertThat(299, `is`(g.score()))
    }

    @Test
    fun testTenthFrameSpare() {
        val g = Game()
        for (i in 0..8) {
            g.add(10)
        }
        g.add(9)
        g.add(1)
        g.add(1)
        assertThat(270, `is`(g.score()))
    }
}
