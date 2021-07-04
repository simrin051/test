var readlineSync = require('readline-sync');

// Wait for user's response.
var userName = readlineSync.question('May I have your name? ');
console.log('Hi ' + userName + '!');
var score =0;

function quiz( question , answer)
{

    var userSucceed=  readlineSync.question(question);
    if(userSucceed===answer)
    {
        score=score+1;
    }
    else if(userSucceed!==answer)
    {
        score =score-1;
    }
}

quiz("will i Succeed","surely");
quiz("Am i older than 25","yes");
console.log("Score "+score);