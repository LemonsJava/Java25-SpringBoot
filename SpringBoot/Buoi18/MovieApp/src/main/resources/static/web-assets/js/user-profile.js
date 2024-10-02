const btnUpdate = document.getElementById("btn-update");
const nameEl = document.getElementById("name");


btnUpdate.addEventListener('click', () => {
    const data = {
        name: nameEl.value
    }
    axios.put("/api/users/update-profile", data)
        .then(res => {
            toastr.success("Cập nhật thông tin thành công");
        })
        .catch(err => {
            console.log(err.response.data.message);
            toastr.error("Cập nhật thông tin thất bại");
        })
})


const btnUpdatePassword = document.getElementById('btn-update-password');
const oldPasswordEl = document.getElementById('oldPassword');
const newPasswordEl = document.getElementById('newPassword');
const confirmPasswordEl = document.getElementById('confirmPassword');
btnUpdatePassword.addEventListener('click', () => {
    const data = {
        oldPassword: oldPasswordEl.value,
        newPassword: newPasswordEl.value,
        confirmPassword: confirmPasswordEl.value
    }
    axios.put("/api/users/update-password", data)
        .then(res => {
            toastr.success("Cập nhật mật khẩu thành công");
        })
        .catch(err => {
            console.log(err.response.data.message);
            toastr.error("Cập nhật mật khẩu thất bại");
        })
})