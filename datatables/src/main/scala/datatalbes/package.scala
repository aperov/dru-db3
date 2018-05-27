import java.time.{Instant, LocalDate, LocalTime}

import slick.jdbc.JdbcType
import slick.jdbc.PostgresProfile.api._

package object datatalbes {

  implicit val localDateToTimeMapper: JdbcType[LocalDate] =
    MappedColumnType.base[LocalDate, java.sql.Date](
      l => java.sql.Date.valueOf(l),
      d => LocalDate.from(d.toInstant))

  implicit val localTimeToDateMapper: JdbcType[LocalTime] =
    MappedColumnType.base[LocalTime, java.sql.Time](
      l => java.sql.Time.valueOf(l),
      _.toLocalTime)
}
