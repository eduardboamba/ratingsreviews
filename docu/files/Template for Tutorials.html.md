---
title: 'Template for Tutorials'
layout: document
service: 'ratingreviews'
type: 'Tutorial'
order: 99
description: ''

---

Provide step-by-step Tutorials or simple walkthroughs to help get the developers started. Include any non programming specifics, such as:

* Initial development environment set up in the cloud (not locally)
* Any authorization or login credentials needed

Provide well-commented code in proper English that developers can use and build upon. Illustrate how to do a simple task using the step-by-step method and gradually add code. If possible, have the developer perform or demonstrate that task by running the code in order for them to see results quickly.

In general, good sample code should follow these guidelines:

* Relevant information should be grouped together.
* Clarity and simplicity is best, instead of trying to show all the features at once.
* Assume the reader has no previous knowledge of the service and explain everything.
* For every 10 lines of code, provide at least one comment, whenever possible.
* If using an example name such as, "ratingreviews" then use it throughout the tutorial.
* Don't forget to provide sample code outside the task. For example, how are errors handled?

Provide detailed information about each class, member, function or XML element. For example, for each item, provide the following:

* A short description
* Description of any parameters and return values
* Any important remarks that assists the developer
* Links to any other related topics
* A snippet of sample code, ideally from the sample code already provided, that helps to explain the item

This could be done in table form:
<style>
table,th,td
{
border:1px solid black;
border-collapse:collapse;
}
th,td
{
padding:5px;
}
th
{
text-align:left;
}
</style>
<table style="width:1000px">
<tr>
  <td><strong>Type</strong></td>
  <td><strong>Name</strong></td>
  <td><strong>Description</strong></td>
</tr>
<tr>
  <td>Metadata</td>
  <td>attribute_nameX</td> 
  <td>A name of the attribute sent using JSON. If the attribute comes from nested data, the name contains a nested path where each level is separated with "." (dot).</td>
</tr>
<tr>
  <td>Audit Fields</td>
  <td>_createdAt and _modifiedAt</td> 
  <td>Each object created in the repository receives these fields by default to keep information about when object was created and when was his last modification performed.</td>
</tr>
</table>
<br>
