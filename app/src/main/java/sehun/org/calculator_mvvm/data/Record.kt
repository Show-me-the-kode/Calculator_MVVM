package sehun.org.calculator_mvvm.data

import java.util.UUID

data class Record(
    val id: String,
    val result: String,
    val expression: String
) {
    companion object {
        fun createEmpty(
            id: String = UUID.randomUUID().toString()
        ): Record = Record(
            id,
            "",
            ""
        )
    }
}
