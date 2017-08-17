# Pre-work - *Name of App Here*

**Basic TODO** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Meher Kasam

Time spent: 2 hours spent in total

## User Stories

The following **required** functionality is completed:

* User can **successfully add and remove items** from the todo list
* User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* User can **persist todo items** and retrieve them properly on app restart

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://raw.githubusercontent.com/meherkasam/AndroidBasicTODO/master/walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** From a development standpoint, writing UI for Android is much closer to writing code for the web, as opposed to writing for iOS. Designing interfaces in iOS is heavily UI driven, whereas you can almost solely rely on the XML editor in Android for the same.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:**
`ArrayAdapter` acts as a bridge between the data source and the `ListView`, and prevents having to setup a direct dependency between the view and the model.
`convertView` allows virtualisation of the `ListView` so that not all of the rows have to be loaded in one go. It allows the reuse of a row the moment it is outside the screen. This is done primarily for efficiency.

## Notes

Describe any challenges encountered while building the app.

## License

    Copyright 2017 Meher Kasam

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.