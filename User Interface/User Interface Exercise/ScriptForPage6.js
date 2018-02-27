let i = 1;
function insF() {
    document.getElementById("h1").innerHTML = i;
    i++;
    if (i === 10) {
        x = document.getElementById("btn");
        x.setAttribute("onclick", "decrF()");
    }
}
function decrF() {
    document.getElementById("h1").innerHTML = i;
    i--;
    if (i === 1) {
        x = document.getElementById("btn");
        x.setAttribute("onclick", "insF()");
    }
}

//----------Next Example------------//

function object1(){
    let person = {
        firstName: "John",
        lastName: "Doe",
        id: 5566,
        fullName: function() {
            return this.firstName + " " + this.lastName;
        }
    };
    document.getElementById("demo").innerHTML = person.fullName();
}
function Person(first, last, age, eye) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eye;
    this.name = function () {
        return this.firstName + " " + this.lastName;
    };
}
function myFunc() {
    var thisPerson = new Person("Vasil", "Totev", 57, "brown");
    document.getElementById("demo2").innerHTML = "This person is " + thisPerson.name() + ", eyes: "
        + thisPerson.eyeColor + ", age: " + thisPerson.age;
}
