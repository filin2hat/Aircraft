package documents

import Document

class ForeignPassport(
    private val series: String,
    private val number: String
) : Document {
    override fun getStringIdentifier(): String = "$series $number"

    override fun getType(): String = "Foreign passport"
}