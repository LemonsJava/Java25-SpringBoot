// Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true
// Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần

let users = [
  {
    name: "Bùi Công Sơn",
    age: 30,
    isStatus: true,
  },
  {
    name: "Nguyễn Thu Hằng",
    age: 27,
    isStatus: false,
  },
  {
    name: "Phạm Văn Dũng",
    age: 20,
    isStatus: false,
  },
];

// Hàm trả về mảng các user có age > 25 và isStatus = true
const filterUsers = (users) => {
  return users.filter((user) => {
    return user.age > 25 && user.isStatus;
  });
};
console.log(filterUsers(users));

// Hàm trả về mảng các user có age tăng dần
const sortUsersByAge = (users) => {
  return users.sort((a, b) => {
    return a.age - b.age;
  });
};

console.log(sortUsersByAge(users));
