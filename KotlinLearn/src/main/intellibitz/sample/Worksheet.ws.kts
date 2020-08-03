package sample

import java.time.LocalDate

val now: LocalDate = LocalDate.now()
val vac = now..now.plusDays(10)
println(now.plusWeeks(1) in vac)
println("$now : $vac")



