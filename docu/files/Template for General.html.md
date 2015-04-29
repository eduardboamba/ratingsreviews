---
title: 'Template for General'
layout: document
service: 'ratingreviews'
type: 'General'
order: 99
description: ''

---

<img style="width:150px" src="img/ratingreviews.png" alt="ratingreviews" style="float:left"> Provide a brief description, in five sentences or less, of your service or API, and an optional icon. Include who would use the service, and *why*.

Include real-world examples where ratingreviews can be used, such as:

* A Credit Card Payment Service that requires some 3rd-party account information
* An Inventory Service enabling you to specify priorities for different sourcing strategies

Succinctly, explain what advantages and benefits are gained by using ratingreviews:

* You can POST a request to `/send` and pass information on the sender, recipient, template name, and attributes to be filled into the email templates.
* You can enable Dynamic Templates to be used for sending emails.


List what all developers can do with ratingreviews, in sentence or table form:
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
<table style="width:800px">
<tr>
  <td><strong>Operations</strong></td>
  <td><strong>Description</strong></td>
</tr>
<tr>
  <td>GET</td> 
  <td>Retrieve the settings of a third party application.</td>
</tr>
<tr>
  <td>PUT</td> 
  <td>Initializes an application with the necessary configured settings.</td>
</tr>
</table>
<br>


Include a table of events ratingreviews provides:
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
<table style="width:800px">
<tr>
  <td><strong>Event Category</strong></td>
  <td><strong>Event</strong></td> 
  <td><strong>Description</strong></td>
</tr>
<tr>
  <td>Cart</td>
  <td>Cart Updated</td> 
  <td>The contents of a defined cart is updated.</td>
</tr>
</table>
<br>



Provide the location for the API console:

* The ratingreviews is reachable at the following location:
http://ratingreviews.dprod.cf.hybris.com/


Provide step-by-step Tutorials, or simple walkthroughs to help get the developers started. See the Tutorials template <link> in the docu directory to input the **Getting Started** information.