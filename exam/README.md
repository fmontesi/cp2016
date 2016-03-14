# Warning: Incomplete!

This document is still incomplete! You will receive an e-mail when it will be
finalised (which will happen soon!).

# Exam Instructions

To pass the course, you have to prepare a software project and a written report
on it. Everything has to be uploaded as a single zip file containing the following:
- `report.pdf`: this is the written report.
- `code`: a directory containing all source code of the software project.

Detailed instructions on the two items are given below.

The deadline for uploading the project on Blackboard is: XX April 2016 at midnight.

## Report

The report must be at the most 3 page long. In the first page, you must state
the name of the course, your name, your e-mail address, and the date (in which
you last edited the document). The report must contain the following sections:
- Methodology. Here you explain how you designed your software. Give a brief
  overview of how it works and then focus on how you handle concurrency.
  For example, did you use futures, executors, manual control over threads,
  and/or monitors? How did you use them?
- Advantages. Here you explain the nice points of your implementation, i.e.,
  the advantages that come out of your design choices.
- Limitations. Here you explain the limitations of your approach and, possibly,
  how they could be overcome. Did you sacrifice performance for achieving better
  readability of your code? Or, did you sacrifice readability for improving
  efficiency? Is there a way to improve how you coordinate concurrent computation?

## Software project

The `code` subdirectory in the zip file must contain a valid Java Application
project created using the [NetBeans IDE](https://netbeans.org/), as the
examples developed during the lectures. This will ensure that I will be able to
compile the project. (I will run `ant jar` in the `code` directory to compile.)

If the code does not compile the exam is automatically failed, so make sure that
it does!

[... Work in Progress]
