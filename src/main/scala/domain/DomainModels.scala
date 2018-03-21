package domain

import java.util.Date

trait PersonName{
  def getFirstName():String
  def getLastName():String
}

trait PersonIdentity{
  def getIdType():String
  def getIdValue():String
}



case class DomainModels(numberOfPeople:Int, amount:BigDecimal)

case class Benefits(benefityType:String, benefitValue:BigDecimal)

case class EmployeeSalary(baseSalary:BigDecimal)

case class Deductions(deductionType:String, deductionValue:BigDecimal)

case class Entries(lowerBand:BigDecimal, upperBand:BigDecimal, taxPercentRate:Int)

case class Taxtable(year:String, entries:List[Entries])

case class Job(jobTitle:String, position:List[EmployeePosition])

case class EmployeePosition(postionCode:String,
                            status:String,
                            job:Job,
                            deductions: List[Deductions],
                            employeeSalary: EmployeeSalary,
                            benefits: List[Benefits])

case class EmployeeContact(cellNumber:String, homeNumber:String)

case class EmployeeAddress(physicalAddress:String, postalAddress:Int,postalCode:Int)

case class Demographics(gender:String, race:String)

case class EmployeePayslip(grossPay:BigDecimal,
                           totalDeductions:BigDecimal,
                           totalTax:BigDecimal,
                           netPay:BigDecimal,
                           payDate: Date)
case class Employee(
                   numberOfDependants:Int,
                   employeeNumber:Int,
                   employeeContact: EmployeeContact,
                   employeeAddress: EmployeeAddress,
                   demographics: Demographics,
                   employeePayslip: EmployeePayslip,
                   employeePosition: EmployeePosition,
                   firstName:String,
                   lastName:String,
                   idType:String,
                   idvalue:String
                   ) extends PersonName with PersonIdentity {
  override def getFirstName(): String = firstName

  override def getLastName(): String = lastName

  override def getIdType(): String = idType

  override def getIdValue(): String = idvalue
}



