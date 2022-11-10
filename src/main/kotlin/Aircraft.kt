abstract class Aircraft(maxWeight: Int) : Transporter(maxWeight) {
    abstract val brand: String
    abstract val model: String
    abstract val engineCount: Int
    abstract val altitude: Int

    abstract val rows: Int
    abstract val numberOfSeatsInARow: Int

    protected val seatScheme by lazy {
        List(rows) {
            MutableList<Passenger?>(numberOfSeatsInARow) {
                null
            }
        }
    }

    fun addPassenger(passenger: Passenger) {
        val row = passenger.seat.row
        val number = passenger.seat.letter - 'A'
        seatScheme[row][number] = passenger
    }

    fun getPassenger(seat: Seat): Passenger? {
        val row = seat.row
        val number = seat.letter - 'A'
        return seatScheme[row][number]
    }

    abstract fun getSeatScheme()
    fun getInfo() =
        """Aircraft: $brand $model
            |Max Weight: $maxWeight
            |Capacity: $capacity
            |Number of rows: $rows
            |Number of seats a row: $numberOfSeatsInARow
        """.trimMargin()
}