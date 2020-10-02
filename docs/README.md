# User Guide

## Features 
1. Add Todo, Deadline, Event tasks
2. Delete tasks at free will
3. Find tasks
4. List tasks
5. Mark tasks as done
6. Saving and loading of Tasks List tasks

### Feature 1 
Add a todo task that only has a description and no deadline
Add a deadline task that has a description and a deadline
Add an event task that has a description and an event date


### Feature 2
Delete any task at free will

### Feature 3
Find any task in your list currently

### Feature 4
List all tasks you currently have

### Feature 5
Mark your tasks as done when you are done with them

### Feature 6
Your tasks are automatically saved and loaded everytime you leave and restart Duke



## Usage
Start the Duke jar file and input the commands as shown below


### `todo [description]` - adds a todo task

Example of usage: 

`todo read book`

Expected outcome:

`Got it. I've added this task:
  [T] ✘ read book
Now you have 7 tasks in the list.`



### `event [description] /at [date]` - adds an event task

Example of usage: 

`deadline read book /at 3 dec`

Expected outcome:

`Got it. I've added this task:
  [E] ✘ read book (at: 3 dec)
Now you have 8 tasks in the list.`


### `deadline [description] /by [date]` - adds a deadline task

Example of usage: 

`deadline read book /by 3 dec`

Expected outcome:

`Got it. I've added this task:
  [D] ✘ read book (by: 3 dec)
Now you have 9 tasks in the list.`


### `done [task number` - marks task as done
Example of usage: 

`done 2`

Expected outcome:

`Nice! I've marked this task as done:
    ✓ read book`

### `delete [task number` - deletes
Example of usage: 

`delete 2`

Expected outcome:

`Noted. I've removed this task: 
  [E] ✓ read book (at: sunday)
Now you have 1 tasks in the list.`

### `find [keyword]` - finds tasks with keyword input
Example of usage: 

`find book`

Expected outcome:

`Here are the matching tasks in your list:
7. [T] ✘ read book`



### `list` - list all your tasks
Example of usage: 

`list`

Expected outcome:

`Here are the tasks in your list:
1.[D] ✘ read book (by: sunday)
2.[E] ✘ read book (at: sunday)`

### `bye` - shutdown duke
Example of usage: 

`bye`

Expected outcome:

`Bye. Hope to see you again soon!`








