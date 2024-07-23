// Tao mot doi tuong

let user = {
    name: 'John',
    age: 30,
    email: 'zY5Pc@example.com',
    address: {
        city: 'New York',
        state: 'NY'
    },
    languages: ['English', 'French'],
    eat: function(food) {
        console.log(`I'm eating ${food}`); 
    },
};

console.log(user.address.city);

let name = user.name;
console.log(name);