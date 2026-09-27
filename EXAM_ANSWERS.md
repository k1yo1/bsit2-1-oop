# LICEO RIDE - Semi-Final Laboratory Exam Answers

Name: Franije S. Khu
Section: BSIT 2-1

## Question 1
Why is the list in RideManager typed ArrayList<Ride> and not ArrayList<Jeepney>?

Your answer:
ArrayList<Ride> is used because it can store different types of rides, such as Jeepney, Tricycle, and Taxi, since they all inherit from the Ride class. This allows RideManager to manage all types of rides using one list and demonstrates polymorphism.

## Question 2
In showStudentDiscounts(), why must you check instanceof before the cast?

Your answer:
The instanceof check makes sure that the ride implements StudentDiscount before casting it. This prevents an invalid cast and avoids a ClassCastException when the ride does not provide a student discount.