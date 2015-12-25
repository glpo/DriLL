$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '15:00 Q1',
            breed1: 2666,
            breed2: null,
            breed3: 2647
        }, {
            period: '15:10 Q2',
            breed1: 2778,
            breed2: 2294,
            breed3: 2441
        }, {
            period: '15:20 Q3',
            breed1: 4912,
            breed2: 1969,
            breed3: 2501
        }, {
            period: '15:30 Q4',
            breed1: 3767,
            breed2: 3597,
            breed3: 5689
        }, {
            period: '15:40 Q1',
            breed1: 6810,
            breed2: 1914,
            breed3: 2293
        }, {
            period: '15:50 Q2',
            breed1: 5670,
            breed2: 4293,
            breed3: 1881
        }, {
            period: '16:00 Q3',
            breed1: 4820,
            breed2: 3795,
            breed3: 1588
        }, {
            period: '16:10 Q4',
            breed1: 15073,
            breed2: 5967,
            breed3: 5175
        }, {
            period: '16:20 Q1',
            breed1: 10687,
            breed2: 4460,
            breed3: 2028
        }, {
            period: '16:30 Q2',
            breed1: 8432,
            breed2: 5713,
            breed3: 1791
        }],
        xkey: 'period',
        ykeys: ['breed1', 'breed2', 'breed3'],
        labels: ['Breed 1', 'Breed 2', 'Breed 3'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Breed #1",
            value: 120
        }, {
            label: "Breed #2",
            value: 300
        }, {
            label: "Breed #3",
            value: 200
        }, {
            label: "Breed #4",
            value: 175
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '15:00',
            a: 100,
            b: 90
        }, {
            y: '15:10',
            a: 75,
            b: 65
        }, {
            y: '15:20',
            a: 50,
            b: 40
        }, {
            y: '15:30',
            a: 75,
            b: 65
        }, {
            y: '15:40',
            a: 50,
            b: 40
        }, {
            y: '15:50',
            a: 75,
            b: 65
        }, {
            y: '16:00',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });
});
