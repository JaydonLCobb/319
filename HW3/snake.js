var isRunning = false; 
var stop = 300;
var x = 0;
var y = 135;
var xMove = 1; 
var yMove = 0;
var update = 1;
var i = 1;

function initStart() {
    var timer = setInterval(main, 20);  // Lower to increase difficulty 
    var start = document.getElementById("start");
    if (isRunning) {
        start.value = "Start";
        isRunning = false;
    } else {
        start.value = "Stop";
        isRunning = true;
    }
}
 
function newStart() {
    if (isRunning) {
        if (x == stop || y == stop) {
            initStart();
        }
        x = x + xMove;
        y = y + yMove;
    }
}

// as timer updates:
// (+/- 1)
// 0 UP
// 2 DOWN
// 1 RIGHT
// 3 LEFT

function rightMove() {
    switch (update) {
        case 0:
            update = 3;
            xMove = -i;
            yMove = 0;
            break;
        case 1:
            update = 0;
            xMove = 0;
            yMove = i;
            break;
        case 2:
            update = 1;
            xMove = i;
            yMove = 0;
            break;
        case 3:
            update = 2;
            xMove = 0;
            yMove = -i;
    }
}

function leftMove() {
    switch (update) {
        case 0:
            update = 1;
            xMove = i;
            yMove = 0;
            break;
        case 1:
            update = 2;
            xMove = 0;
            yMove = -i;
            break;
        case 2:
            update = 3;
            xMove = -i;
            yMove = 0;
            break;
        case 3:
            update = 0;
            xMove = 0;
            yMove = i;
    }
}

function main() {
    newStart();
    var ctx = document.getElementById('myCanvas').getContext('2d');
    ctx.fillStyle = "#FF0000";
    ctx.fillRect(x, y, 5, 5);
}