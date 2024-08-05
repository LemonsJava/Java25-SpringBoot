//Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần

const strNumbers = ["one", "two", "three", "one", "one", "three"];

function count(strNumbers) {
  let count = {};
  for (let i = 0; i < strNumbers.length; i++) {
    if (count[strNumbers[i]]) {
      count[strNumbers[i]]++;
    } else {
      count[strNumbers[i]] = 1;
    }
  }
  return count;
}

console.log(count(strNumbers));
