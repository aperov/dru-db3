package datatalbes

import java.time.LocalDate

import slick.jdbc.H2Profile.api._

class PassengerInTripTable(tag: Tag) extends Table[model.PassengerInTrip](tag, "Pass_in_trip"){
  val tripId = column[Int]("trip_no", O.PrimaryKey)
  val passengerId = column[Int]("ID_psg", O.PrimaryKey)
  val date = column[LocalDate]("date", O.PrimaryKey)
  val place = column[String]("place")

  val passengerIdForeignKey = foreignKey("trip_id_fk", passengerId, PassengerTable.table)(
    _.passengerId , ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)

  val companyIdForeignKey = foreignKey("trip_id_fk", tripId, CompanyTable.table)(
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)

  def * = (tripId, passengerId, date, place).mapTo[model.PassengerInTrip]
}

object PassengerInTripTable {
  val table = TableQuery[PassengerInTripTable]
}