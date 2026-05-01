🏙️ True Dream Realty

welcome to true dream realty
where the properties are unreal and the money very much is.

this is a java CLI application designed to track financial transactions for a high-end (and slightly suspiciously successful) real estate business. every dollar in and out is logged, categorized, and displayed through a clean command-line interface.

✨ features
home screen navigation
add deposit 💰
make payment 💸
view ledger 📖
exit (snuff the candle fr)
transaction tracking
all transactions saved to transactions.csv

format:

date|time|description|vendor|amount
ledger system
view all entries
filter deposits (money in)
filter payments (money out)
transactions displayed newest → oldest
reports (for when u feeling like a real accountant fr)
month to date
previous month
year to date
previous year
search by vendor
🧠 how it works
transactions are stored in a CSV file and loaded into the program at runtime
new deposits and payments are created using the current date and time
payments are stored as negative values (because yeah… money gone)
deposits are stored as positive values (money up only 🫡)
🛠️ tech used
java
file I/O (BufferedReader, FileWriter)
ArrayList for storing transactions
LocalDate & LocalTime for timestamps
📁 project structure
com.pluralsight
│
├── HomeScreen.java        // main menu + app loop
├── LedgerManager.java    // handles deposits & payments
├── Ledger.java           // displays transactions
├── Transaction.java      // transaction object model
├── TransactionFileManager.java // reads/writes CSV
💅 vibe

this is not just a ledger.
this is a luxury financial tracking experience.

think:

penthouse rent payments
suspiciously rich tenants
vendors that sound like supervillains
and a CEO (me☺️) who definitely knows what they’re doing
🚀 future upgrades
custom search filters
red payments , green deposits

true dream realty is:

100% legal
0% fraudulent
definitely not laundering money through luxury duplexes with rooftop jungle access
🖤 final note

built with sleep deprivation, ambition, and a slightly unhinged sense of humor.
