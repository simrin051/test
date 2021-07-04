
var path = "/a/./b/../../c/";
var index=0;

if(path.includes("/../"))
{
    console.log("Reached here");
    path=path.split("/../").join("/");
    console.log("Path 11234"+path);
}
if(path.charAt(path.length-1)=='/')
{
   path = path.slice(0, -1);

}
if (path.includes("//"))
{
  index=path.indexOf("//");
  console.log("Index "+index);
  path = path.slice(0,index) +path.slice(index,1) + path.slice(index+1);
  console.log("Path "+path);
}












