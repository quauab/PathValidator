# Path Validator
Verify path is a file, directory or that the path exists and is not a symbolic link or verify a path, whether file or directory is a symbolic link.

<h2>Installation</h2>
<ol>
  <li>Download project's zip</li>
  <li>Compile project</li>
  <li>Generate jar library</li>
  <li>Add jar as external library</li>
</ol>

<h2>Motivation</h2>
Inspired by previous projects that required file or directory verification. Uploaded to Github as reference or possible Java library for others.

<h2>Notes</h2>
The PathValidator methods will throw a NullPointerException if it's String argument is null, empty or if the file path does not exist.
