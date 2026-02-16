Problem Statement: Library Lending System
Build a Library Lending System that allows a library to manage books and members, and supports borrowing and returning of books. The system should handle basic library operations and enforce simple borrowing rules.
The team will work together on a single codebase, discuss the design, decide how to divide the work, and implement the solution collaboratively.

Features
Books

Add books to the library
List all books
Track how many copies of each book are available
Members

Add library members
Support different member types (e.g., Student, Regular)
Borrow Book

A member can borrow a book only if at least one copy is available
Borrowing a book should reduce the available copy count
Enforce borrowing limits based on member type
Return Book

Returning a book should increase the available copy count
If a book is returned late, calculate a fine based on member type


DB - library
tables - books(id,title,author,available)
         users(id,name,type,mobile_number)
         borrow_record(borrowed_id,user_id,book_id,borrowed_date,returned_date,due_date,fine_amount)