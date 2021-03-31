# Software design final project
Link to repo on github: https://github.com/mcbe1985/Final_Project


## Introduction
For the course 5-Software Design we were tasked to program a Java application with workings similar to the popular Splitwise Application.
The goals and must haves for this project can be found under the /dov/Lab6.pptx file.

## Usage of the database commands
This project uses a central database wherein one can find a seperate vector for the users, groups and tickets. These can be added/edited/deleted by the users command.
The functions of each of these classes are also available upon request, although they can't always be called directly.
For this, we're using specific getters and setters to make the necessary adjustments.

* To get the name of a specific user/group from the database:
```java
// The ID being used here is the ID from the user/group we're looking for. In this example this has been set to 0.
int id = 0;
// In reality this ID will come from a list that has been called from the database.
// Getting the name of a user:
db.getUserEntry(id).getName(); 
// Getting the name of a group:
db.getGroupEntry(id).getName()
```

* Calling all user ID's from a group:
```java
// The method getUsersFromGroup asks for the ID of the group from which we want a List of all its users. The list will contain the ID's of seperate users and thus the method returns an Integer List as an answer.
int id = 0;
List<Integer> userIDList = db.getUsersFromGroup(id);
// In the userIDList all user ID's that are currently a member of the group can be found.
```

* Calling the group ID's to which a specific user is a member of:
```java
// The method getGroupIDList returns an Integer List containing the ID's of all the groups a user is currently a member of. The ID asked here is for the specific user from which we want the list.
int id = 0;
db.getUserEntry(id).getGroupIDList()
```

* Get the name of the user and the amount they need to pay (per person) in a group:
```java
// We need the ID of the group we want the users and tickets from.
int id = 0;
List<Integer> userIds = db.getUsersFromGroup(id);
List<Integer> ticketIds = db.getGroupEntry(id).getTicketIDList();

// First we'll go through all the different tickets that are currently in circulation in the group.
for (int i = 0; i < ticketIds.size(); i++){
    // The next step is to go through all the users of the group so we can print the amount each user owes. Since the ID's of the amounts in the ticketIDlist of the group equal those in the userIDlist they are equal.
    for (int j = 0; j < userIds.size(); j++) {
        System.out.println("The user " + db.getUserEntry(userIds.get(j)).getName() + " currently has to pay: " + db.getTicketEntry(ticketIds.get(i)).getTicketAmount(j));
    }
}
```

* Get a list of all tickets related to a user:
```java
int id = 0;
db.getUserEntry(id).getTickets()
```

* Get the total amount of money spent in a ticket:
```java
int id = 0
db.getTicketEntry(id).getTotalAmount()
```


```java

```