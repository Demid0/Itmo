import Vue from "/vue";
import App from "../components/App.vue";

new Vue ({
    el: '#app',
    render: a => a(App)
})

function validate(point) {
    function between(a, from, to) {
        return !(a == null || isNaN(a)) && (from <= a && a <= to)
    }
    let x = parseFloat(point.x);
    let y = parseFloat(point.y);
    let r = parseInt(point.r);
    return between(x, -4, 4) && between(y, -5, 5) && between(r, -4, 4);
}

/*
    <svg width="600px" height="600px" @click="checkFromSVG(event)">
    <!-- arrows -->
    <polygon points="300,0 290,20 310,20" stroke="#2c2d2a"/>
    <polygon points="600,300 580,290 580,310" stroke="#2c2d2a"/>

    <!-- rectangle -->
    <polygon points="100,100 100,300 300,300 300,100" fill="#0783ff"/>

    <!-- triangle -->
    <polygon points="100,300 300,300 300,400" fill="#0783ff"/>

    <!-- circle -->
    <path d="M 400,300 A 100,100 90 0,1 300,400 L 300,300 Z" fill="#0783ff"/>

    <!-- axis -->
    <line x1="0" x2="600" y1="300" y2="300" stroke="#2c2d2a"/>
    <line x1="300" x2="300" y1="0" y2="600" stroke="#2c2d2a"/>

    <!-- labels on the axis x -->
    <line x1="100" x2="100" y1="290" y2="310" stroke="#2c2d2a"/>
    <line x1="200" x2="200" y1="290" y2="310" stroke="#2c2d2a"/>
    <line x1="400" x2="400" y1="290" y2="310" stroke="#2c2d2a"/>
    <line x1="500" x2="500" y1="290" y2="310" stroke="#2c2d2a"/>

    <!-- labels on the axis y -->
    <line x1="290" x2="310" y1="100" y2="100" stroke="#2c2d2a"/>
    <line x1="290" x2="310" y1="200" y2="200" stroke="#2c2d2a"/>
    <line x1="290" x2="310" y1="400" y2="400" stroke="#2c2d2a"/>
    <line x1="290" x2="310" y1="500" y2="500" stroke="#2c2d2a"/>

    <line x1="0" x2="0" y1="0" y2="600" stroke="#2c2d2a"/>
    <line x1="0" x2="600" y1="0" y2="0" stroke="#2c2d2a"/>
    <line x1="600" x2="600" y1="600" y2="0" stroke="#2c2d2a"/>
    <line x1="0" x2="600" y1="600" y2="600" stroke="#2c2d2a"/>

    <!-- axis labels -->
    <text x="580" y="280">x</text>
    <text x="310" y="20">y</text>

    <!-- R values on the axis x -->
    <text x="80" y="276"></text>
    <text x="170" y="276"></text>
    <text x="380" y="276"></text>
    <text x="490" y="276"></text>

    <!-- R values on the axis y -->
    <text x="324" y="508"></text>
    <text x="324" y="408"></text>
    <text x="324" y="208"></text>
    <text x="324" y="108"></text>
    </svg>

Vue.component('image', {
    template: '',
    data: function () {
        var points = []
        pointAPI.get().then( result =>
            result.json().then( data =>
                data.forEach( point =>
                    points.push(point)
                )
            )
        )
        return points
    },
    methods: {
        checkFromSVG: function (event) {
            let target = document.querySelector("svg").getBoundingClientRect();
            let rDiv = document.getElementById("r");
            if (!(rDiv.value == null || isNaN(rDiv.value))) {
                let px = event.clientX - target.left;
                let py = event.clientY - target.top;
                let x = ((px - 300) * rDiv.value / 200).toFixed(2);
                let y = (-(py - 300) * rDiv.value / 200).toFixed(2);
                let point = {
                    x : x,
                    y : y,
                    r : rDiv.value,
                    time : new Date().toLocaleTimeString()
                };
                pointAPI.save(point).then(result =>
                    result.json().then(data => {
                        if (data['id'] === -1) {}
                        else this.points.push(data);
                        document.getElementById("x").value = '';
                        document.getElementById("r").value = '';
                        this.y = '';
                    })
                )
            }
        }
    }
})*/
