# Computer Science 112 Fall 2016

This repository contains the LaTeX and HTML source code for the laboratory and
practical assignments, course teaching slides, study guides, and the syllabus
for Computer Science 112, Fall 2016.  Taught by [Gregory M.
Kapfhammer](http://www.cs.allegheny.edu/sites/gkapfham) in the [Department of
Computer Science](http://www.cs.allegheny.edu) at [Allegheny
College](http://www.allegheny.edu), the course has the following description:

> A continuation of Computer Science 111 with an emphasis on data structures, data abstraction, algorithm design, the
> analytical and experimental evaluation of algorithm performance, and object-oriented design and implementation
> techniques. Topics include stacks, queues, deques, lists, strings, trees and graphs, dictionaries, recursion,
> searching and sorting algorithms, and an introduction to program verification. One laboratory per week. Prerequisite:
> Computer Science 111 or permission of the instructor. Distribution Requirements: QR, SP.\@ \\

The source code of the LaTeX documents uses a custom LaTeX style file and several other packages that are normally
standard with a modern LaTeX distribution such a TeXLive 2015. All of the slides are programmed with the
[reveal.js](https://github.com/hakimel/reveal.js/) framework. The background images in the slides were all collected
from the [Flickr Creative Commons](https://www.flickr.com/creativecommons/) through the use of the
[cogdog/flickr-cc-helper](https://github.com/cogdog/flickr-cc-helper) tool.

You are invited to use this repository as a means for learning more about instruction in an introductory computer
science course. If you find this repository useful, could I trouble you to star it and then acknowledge it in your own
teaching efforts?

You can type the following command if you want to clone this repository:

```shell
git clone https://github.com/gkapfham/cs112F2016.git
```

If you want to compile the LaTeX document to a PDF, then you should type the following commands. In this example, I
show how to compile the syllabus for the course.

```shell
cd cs112F2016
cd syllabus
pdflatex cs112F2016_syllabus.tex
```

If you want to view the slides, then you should type the following commands. In this example, I show how to view the
slides for the first chapter of the textbook.

```shell
cd cs112F2016
cd slides
chromium-browser cs111_chapter1.html
```

Please note that the LaTeX documents have been compiled on an Ubuntu 15.04 workstation running a very recent version of
LaTeX that was manually installed using the TeXLive installer.  It is also worth noting that you can also compile the
documents using other LaTeX development tools, such as `latexmk`. If you are unable to compile the LaTeX source code
with your development tools and your execution environment, then please open a new issue and I will attempt to resolve
your concerns.

Additionally, the HTML slides have been tested on modern Web browsers (e.g., Chrome and Firefox) that run on the Ubuntu
and Android operating systems.  If the HTML slides do not correctly display on your Web browser, then I also encourage
you to open an issue so that I can handle the problem that you have found.
