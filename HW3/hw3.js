var rs = require('readline-sync');

var fNum1 = rs.question('1st Number: ');
var fNum2 = rs.question('2nd Number: ');
var fNum3 = rs.question('3rd Number: ');
var fNum4 = rs.question('4th Number: ');

function factorial(fNum1) {
    var res = 1;
    if (fNum1 <= 1) {
        return res;
    }
    for (var i = 1; i <= fNum1; i++) {
        res = res * i;
    }
    return res;
}

function sum(fNum2) {
    var sum = 0;
    while (fNum2 > 0) {
        var mod = fNum2 % 10;
        sum += mod;
        fNum2 = parseInt(fNum2 / 10); 
    }
    return sum;
}

function reverse(fNum3) {
    var reverse = 0;
    while (fNum3 > 0) {
        var mod = fNum3 % 10;
        reverse = reverse * 10 + mod;
        fNum3 = parseInt(fNum3 / 10); 
    }
    return reverse;
}

function isPalindrome(fNum4) {
num = reverse(fNum4);
if (fNum4 == num) {
    return true;
} else {
    return false;
}
}

var factorialRes = factorial(fNum1);
var sumRes = sum(fNum2);
var reverseRes = reverse(fNum3);
var palindromeRes = isPalindrome(fNum4);


console.log("Factorial of the 1st number = "+ factorialRes);
console.log("The sum of all digits of the 2nd number is = "+ sumRes);
console.log("The reverse of the 3rd number is = "+ reverseRes);
console.log("Is the 4th number a palindrome (True/False)? = "+ palindromeRes);


//var action = rs.question('Enter the action{+,-,*,/,%}');
//var result = fNum1 + action + fNum2
//var result = eval(result);
//console.log(result);
