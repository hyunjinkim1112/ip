# Mary User Guide

![img.png](img.png)
This is a Java chatbot which has simple features to manage your schedule. 

## Adding todos ```todo```
adds a todo item to the list  <br>
**Format:** `todo {short description}`<br>
**Example:** `todo eat lunch with Sam`<br>
**Expected Output:** 
```
____________________________________________________________ 
Got it. I've added this task:
	[T][ ] eat lunch with Sam
Now you have 1 task(s) in the list.
____________________________________________________________ 
```
## Adding deadlines ```deadline```
adds a deadline item to the list <br>
**Format:** `deadline {short description} /by {time}`<br>
**Example:** `deadline finish hw /by 02-03-2025 3pm`<br>
**Expected Output:**
```
____________________________________________________________ 
Got it. I've added this task:
	[D][ ] finish hw (by: 02-03-2025 3pm)
Now you have 2 task(s) in the list.
____________________________________________________________ 
```
## Adding events ```event```
adds a event item to the list<br>
**Format:** `event {short description} /from {time} /to {time}`<br>
**Example:** `event field trip to Vietnam /from 02-05-2025 /to 02-10-2025`<br>
**Expected Output:**
```
____________________________________________________________ 
Got it. I've added this task:
	[E][ ] field trip to Vietnam (from: 02-05-2025 to: 02-10-2025)
Now you have 3 task(s) in the list.
____________________________________________________________ 
```

## Displaying the list ```list```
displays all the items in the list <br>
**Format:** `list`<br>
**Example:** `list`<br>
**Expected Output:**
```
____________________________________________________________ 
Here are the tasks in your list:
	1. [T][ ] eat lunch with Sam
	2. [D][ ] finish hw (by: 02-03-2025 3pm)
	3. [E][ ] field trip to Vietnam (from: 02-05-2025 to: 02-10-2025)
____________________________________________________________ 

```

## Marking the given task as done ```mark```
marks the given item as done<br>
**Format:** `mark {number of the task}`<br>
**Example:** `mark 1`<br>
**Expected Output:**
```
____________________________________________________________ 
Nice! I've marked this task as done: 
	[T][X] eat lunch with Sam
____________________________________________________________ 
```

## Marking the given task as undone ```unmark```
marks the given item as undone<br>
**Format:** `unmark {number of the task}`<br>
**Example:** `unmark 1`<br>
**Expected Output:**
```
____________________________________________________________ 
Nice! I've marked this task as not done yet: 
	[T][ ] eat lunch with Sam
____________________________________________________________ 
```
## Finding the task with the given keyword ```find```
finds the task items with the given keyword from the list and shows them <br>
**Format:** `find {a word in the task you are looking for}`<br>
**Example:** `find trip`<br>
**Expected Output:**
```
____________________________________________________________ 
Here are the matching tasks in your list.
	1. [E][ ] field trip to Vietnam (from: 02-05-2025 to: 02-10-2025)
____________________________________________________________ 

```

## Terminating the program ```bye```
ends the program <br>
**Format:** `bye`<br>
**Example:** `bye`<br>
**Expected Output:**
```
Saving 3 tasks to ./data/mary.txt
```
