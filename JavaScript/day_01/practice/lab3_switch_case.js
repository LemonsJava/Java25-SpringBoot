/*
Bài tập 1
Tạo biến day có giá trị từ 0 -> 6, là các ngày trong tuần Trong đó: (0 - chủ nhật, 1 - thứ 2, …, 6 - Thứ 7)
Sử dụng switch-case để in ra ngày tương ứng với giá trị của biến day
Ví dụ: day = 6 --> “Hôm nay là thứ 7”
*/

let day = prompt('Enter a day: ');

switch (day) {
    case '0':
        console.log('Chủ nhất');
        break;
    case '1':
        console.log('Thứ 2');
        break;
    case '2':
        console.log('Thứ 3');
        break;
    case '3':
        console.log('Thứ 4');
        break;
    case '4':
        console.log('Thứ 5');
        break;
    case '5':
        console.log('Thứ 6');
        break;
    case '6':
        console.log('Thứ 7');
        break;
    default:
        console.log('Ngày nhập vào không hợp lệ');
}


/*
Bài tập 2

Tạo biến month có giá trị từ 1 -> 12, là các tháng trong năm
Sử dụng switch-case để in ra mùa tương ứng với giá trị của biến month
1, 2, 3 : Mùa xuân
4, 5, 6 : Mùa hạ
7, 8, 9 : Mùa thu
10, 11, 12 : Mùa đông
Ví dụ: month = 9 --> “Mùa thu”
*/

let month = prompt('Enter a month: ');

switch (month) {
    case '1':
    case '2':
    case '3':
        console.log('Mùa xuân');
        break;
    case '4':
    case '5':
    case '6':
        console.log('Mùa hạ');
        break;
    case '7':
    case '8':
    case '9':
        console.log('Mùa thu');
        break;
    case '10':
    case '11':
    case '12':
        console.log('Mùa đông');
        break;
    default:
        console.log('Tháng nhập vào không hợp lệ');
}