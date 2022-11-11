class Boeing737 : Aircraft(10000) {
    override val brand = "Boeing"
    override val model = "737"
    override val engineCount = 2
    override val altitude = 12500
    override val rows = 40
    override val numberOfSeatsInARow = 6


    override fun getSeatScheme() {
        println("  ABC  DEF")
        seatScheme.forEachIndexed { rowIndex, row ->
            println("${rowIndex + 1} ")
            row.forEachIndexed { seatIndex, passenger ->
                if (passenger == null) println("_") //если место пустое то "_"
                else println("X")  //если есть пассажир то "X"
                if (seatIndex == row.lastIndex / 2) println("  ") //добавили проход на схему
            }
            println()
            if (rowIndex != 0 && rowIndex % 10 == 0) println() //добавили места у дверей
        }
    }

    override val capacity: Int = rows * numberOfSeatsInARow
}