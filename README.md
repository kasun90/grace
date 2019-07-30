# grace

Simple markdown like text processor for developers.

This is intended to be used together with [React Grace](https://www.npmjs.com/package/react-grace). You can directly feed the 
processed result from [Grace](https://github.com/kasun90/grace) to this React component.


### Usage

```
Document process = Processor.process(new File("sample.txt"));
ExportableTagRenderer tagRenderer = ExportableTagRenderer.builder().build();
ExportableTag render = tagRenderer.render(process);
```

This ``ExportableTag`` can be directly fed in to the React component.

Supported formats are below

### Paragraph

Anything without any special notation is a paragraph. Paragraph breaks can be achieved by 
new lines.

### Header

\# This is an H1

\## This is an H2

\###### This is an H6

### Note

!!  
This is a note  
!!


### Image

!(your/image/url/here)

### Unordered List

** list item 1  
** list item 2  
** list item 3

### Ordered List

*@ list item 1  
*@ list item 2  
*@ list item 3  


### Terminal Prompt

\```  
$ This is a command  
$ This is another command  
\```

### Code

\``  
This can be anything which appears as code or console text  
\``

### Gist

A gist can be used to quickly showcase a coding snippet. 

Example

````  
[gist](kasun90/76ec75f3d7922c7f8d2dd11030342a0b)
````

Syntax  

````
[gist](<github_username>/<gist_id>)
````