package aircrafts

import Aircraft

class Zeppelin : Aircraft(1500) {
    override val brand: String = "aircrafts.Zeppelin"
    override val model: String = "NT"
    override val engineCount = 3
    override val altitude: Int = 2600
    override val rows = 1
    override val numberOfSeatsInARow = 12

    override fun getSeatScheme() {
        val seats = seatScheme.first().map {
            if (it == null) "_"
            else "X"
        }
        val scheme = """
                  ${seats[0]}   ${seats[1]}
                ${seats[2]}       ${seats[3]}
              ${seats[4]}           ${seats[5]}
            ${seats[6]}               ${seats[7]}
            ${seats[8]}               ${seats[9]}
            ${seats[10]}               ${seats[11]}
        """.trimIndent()
        println(scheme)

    }

    override val capacity = rows * numberOfSeatsInARow
}