object TaskManager{
    def allTasksDueToday(tasks:List[Task]):List[Task]=tasks.filter(t=>t.dueOn.isEqual(LocalDate.now))
}
