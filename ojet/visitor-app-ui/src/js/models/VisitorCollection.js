define(['ojs/ojmodel', 'models/VisitorModel'], function (oj, VisitorModel) {
    var VisitorCollection = oj.Collection.extend({
        url: 'http://localhost:9090/visitors',
        model: VisitorModel
    });
    return VisitorCollection;
});
