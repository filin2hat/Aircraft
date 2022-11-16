package documents

import Document

class DeputyID(
    private val number: String
) : Document {
    override fun getStringIdentifier(): String = number
    override fun getType(): String = "Deputy ID"
}