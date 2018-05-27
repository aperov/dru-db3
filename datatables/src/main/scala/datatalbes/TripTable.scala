package datatalbes //insert,primarykey, triptable object

import java.time.LocalTime

import slick.jdbc.H2Profile.api._

class TripTable(tag: Tag) extends Table[model.Trip](tag,"Trip"){
  val id = column[Int]("trip_no")
  val companyId = column[Int]("ID_comp")
  val plane = column[String]("plane")
  val townFrom = column[String]("town_from")
  val townTo = column[String]("town_to")
  val timeOut = column[LocalTime]("time_out")
  val timeIn = column[LocalTime]("time_in")

  val companyIdForeignKey = foreignKey("company_id_fk", companyId, CompanyTable.table)(
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)

  def * = (id, companyId, plane, townFrom, townTo, timeOut, timeIn).mapTo[model.Trip]// <> (model.Trip.apply _).tupled, model.trip.unapply
}

object TripTable{
  val table = TableQuery(TripTable)
}
