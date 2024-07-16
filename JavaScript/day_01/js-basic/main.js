document.write("Hello World");
console.log("Hello World");
console.log("Hello Viet Nam");
console.log("Hello Ho Chi Minh");

// Khai báo biến trong JavaScript
let a;
console.log(a);
a = 18;
console.log(a);

const b = 20;
console.log(b);


// Template Strings - ES6
let name = "John Doe";
let age = 50;
let message = `Hello, my name is ${name} and I am ${age} years old.`;
console.log(message); 

// No template strings
let name1 = "Haha";
let age1 = 19;
let message1 = "Hello, my name is " + name1 + " and I am " + age1 + " years old.";
console.log(message1);

console.log(1 + '2'); // 
console.log(12 / "4"); // 3

//Function
// Regular function
function sum(a, b) {
    return a + b;
}
console.log(sum(1, 2));

// Function expression
let sum1 = function(a, b) {
    return a + b;
}
console.log(sum1(1, 2));

// Arrow function (ES6) - Lambda function (Java8)
let sum2 = (a, b) => a + b;
console.log(sum2(1, 2));
