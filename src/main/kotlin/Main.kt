import aircrafts.Boeing737
import aircrafts.Zeppelin
import documents.DeputyID
import documents.ForeignPassport
import kotlin.random.Random

fun main() {
    val boeing737 = Boeing737()
    fillAircraft(boeing737)
    println(boeing737.getInfo())
    boeing737.getSeatScheme()
    printPassengerInfo(boeing737, Seat(0, 'c'))
    printPassengerInfo(boeing737, Seat(3, 'a'))
    printPassengerInfo(boeing737, Seat(25, 'd'))
    printPassengerInfo(boeing737, Seat(10, 'e'))

    println("\n========================================================================\n")

    val zeppelin = Zeppelin()
    fillAircraft(zeppelin)
    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
    printPassengerInfo(zeppelin, Seat(0, 'c'))
}

fun printPassengerInfo(aircraft: Aircraft, seat: Seat) {
    aircraft.getPassenger(seat)
        ?.getInfo()
        ?.let { println(it) }
        ?: println("There is no passenger.")
}

fun fillAircraft(aircraft: Aircraft) {
    val passengersCount = Random.nextInt(1, aircraft.capacity)
    for (i in 0 until passengersCount) {
        val seat = aircraft.getAvailableSeat() ?: return
        val passenger = Passenger(
            name = "John",
            lastName = "Doe",
            document = getDocument(aircraft),
            seat = seat
        )
        aircraft.addPassenger(passenger)
    }
}

fun getDocument(aircraft: Aircraft): Document {
    return if (aircraft is Zeppelin) {
        DeputyID(
            number = Random.nextInt(100000, 999999).toString()
        )
    } else {
        ForeignPassport(
            series = Random.nextInt(1000, 9999).toString(),
            number = Random.nextInt(100000, 999999).toString()
        )
    }
}

fun getRandomDocument(): Document =
    when (Random.nextInt(0, 2)) {
        0 -> ForeignPassport(
            series = Random.nextInt(1000, 9999).toString(),
            number = Random.nextInt(100000, 999999).toString()
        )

        else -> DeputyID(
            number = Random.nextInt(100000, 999999).toString()
        )
    }